<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when test="${empty order}">
		<div class="empty-order">
         <img src="${pageContext.request.contextPath}/img/storeorderconfirmed.png" alt="empty" class="empty-img">
     </div>
	</c:when>
	<c:otherwise>
		<c:forEach var="vo" items="${order}">
			<div class="order-card">
			       <div class="order-card-header">
			           <span class="order-card-title">오굿백 ${vo.quantity}개 예약</span>
			           <div class="order-card-button">
			           	<c:set var="btnStatus" value="${vo.order_status eq 'pickup' ? 'complete' : 'today'}" />
			               <button class="order-card-btn" data-status="${btnStatus}">
			                <c:choose>
			                	<c:when test="${vo.order_status eq 'pickup' }">픽업완료</c:when>
			                	<c:otherwise>오늘픽업</c:otherwise>
			                </c:choose>
			              </button>
			           </div>
			           <div class="order-group">
			               <label>
			                   <input type="checkbox" class="order-checkbox" 
			                   <c:if test="${not empty vo.pickup_start}">
		  										data-pickup-start="<fmt:formatDate value='${vo.pickup_start}' pattern='yyyy-MM-dd\'T\'HH:mm:ss' />"
											</c:if>
			                    			data-order-no="${vo.order_no}" 
			                    			<c:if test="${not empty vo.pickup_end}">
		  										data-pickup-end="<fmt:formatDate value='${vo.pickup_end}' pattern='yyyy-MM-dd\'T\'HH:mm:ss' />"
											</c:if>
			                    			<c:if test="${vo.order_status eq 'pickup'}">checked</c:if> style="display:none; disabled">
			                     <img class="checkbox-img" 
										src="${pageContext.request.contextPath}/img/${vo.order_status eq 'pickup' ? 'storerealnoncheck' : 'storenoncheck'}.png" disabled/>
			               </label>
			           </div>
			           <span class="order-card-date">
			           		<fmt:formatDate value="${vo.ordered_at}" pattern="yyyy.MM.dd"/>
			           </span>
			       </div>
			       <hr class="order-card-divider">
			       <div class="order-card-body">
			           <img src="https://ohgoodfood.s3.ap-northeast-2.amazonaws.com/${vo.store_img}" alt="오굿백" class="order-card-img">
			           <div class="order-card-info">
			               <div class="order-card-info-person"><b>예약자 :</b> ${vo.user_nickname}</div>
			               <div class="order-card-info-time"><b>픽업 시간 :</b>
			               	<fmt:formatDate value="${vo.pickup_start}" pattern="HH:mm" />
							~
							<fmt:formatDate value="${vo.pickup_end}" pattern="HH:mm" />
			               </div>
			               <div class="order-card-info-ctime">
			               	<b>결제 금액 :</b> 
			               	 ${(vo.paid_price != null ? vo.paid_price : 0) + (vo.paid_point != null ? vo.paid_point : 0)}₩
			               	</div>
			               <div class="order-card-btns">
			                   <button class="order-btn-pickup">픽업코드 : ${vo.order_code}</button>
			               </div>
			           </div>
			       </div>
			   </div>
		</c:forEach>
	</c:otherwise>
</c:choose>
    <script>
	// 체크박스 선택시 이미지 변경 로직
        document.querySelectorAll('.order-checkbox').forEach(function (checkbox) {
	         checkbox.addEventListener('change', function () {
	            const img = this.nextElementSibling;
	            const label = this.parentElement;
	            if (this.checked) {
	                img.src = '${contextPath}/img/storerealnoncheck.png';    
	                label.style.fontWeight = "normal";   
	            } else {
	                img.src = '${contextPath}/img/storenoncheck.png';
	                label.style.fontWeight = "normal"; 
	            }
	          });
        });
	//오늘픽업, 픽업완료 별로 동적 css
        $(document).ready(function () {
            $('.order-card').each(function () {
                const $orderBtn =$(this).find('.order-card-btn');
                const status = $orderBtn.data('status');
                const $pickupBtn = $(this).find('.order-btn-pickup');
                if (status === 'complete') {
                    $pickupBtn.css({
                        'text-decoration': 'line-through',
                        'color': '#8B6D5C'
                    });
                    $orderBtn.css({
                        'background-color': '#8B6D5C',
                        'color': '#FFFFFF',
                        'border': '1px solid #8B6D5C'
                    });
                } else if (status === 'today') {
                    $orderBtn.css({
                        'background-color': '#D8A8AB',
                        'color': '#FFFFFF',
                        'border': '1px solid #D8A8AB'
                    });
                }
            });
        });
	// 확정시간, 픽업시간 시간 예외처리 및 ajax
        $(document).ready(function() {
		    $('.order-checkbox').click(function(e) {
				const $checkbox = $(this);
		        const pickupStartStr = $(this).data('pickup-start');
		        const pickupEndStr = $(this).data('pickup-end'); 
		        let pickupStart = new Date(pickupStartStr);
		        let pickupEnd = new Date(pickupEndStr);
				const orderNo = $(this).data('order-no');
		        const isChecked = $(this).is(':checked');
		        const $parentCard = $(this).closest('.order-card');
		        const $btn = $parentCard.find('.order-card-btn');
		        const now = new Date();
				if (now < pickupStart || now > pickupEnd) {
					alert('픽업 시간이 아닙니다');
					e.preventDefault();
					$checkbox.prop('checked', !isChecked);
					return false;
				}
		        if (isChecked && now >= pickupStart && now <= pickupEnd) {
		        	$(this).siblings('.checkbox-img').css({
		        	    'pointer-events': 'auto',
		        	    'opacity': 1
		        	});
		        	$(this).prop('disabled', false);
		            if (confirm('픽업 완료로 바꾸시겠습니까?')) {
		                const url = contextPath + "/store/confirmed/" + orderNo + "/pickup";
		                $.post(url, function (res) {
		                    if (res === 'success') {
		                        $btn.text('픽업 완료')
		                            .css({ 'background-color': '#8B6D5C', 'color': '#fff', 'border': '1px solid #8B6D5C' })
		                            .attr('data-status', 'complete');
		                        $parentCard.find('.order-btn-pickup').css({
		                            'text-decoration': 'line-through',
		                            'color': '#8B6D5C'
		                        });
		                    } else {
		                        alert('픽업 완료 처리 실패');
		                        $(this).prop('checked', false);
		                    }
		                }).fail(() => {
		                    alert('ajax 실패');
		                    $(this).prop('checked', false);
		                });
		            } else {
		                $(this).prop('checked', false);
		            }
		        } else if(!isChecked && now >= pickupStart && now <= pickupEnd){
		        	$(this).siblings('.checkbox-img').css({
		        	    'pointer-events': 'auto',
		        	    'opacity': 1
		        	});
		        	$(this).prop('disabled', false);
		            if (now >= pickupStart && now <= pickupEnd) {
		                if (confirm('오늘 픽업으로 바꾸시겠습니까?')) {
		                    const url = contextPath + "/store/confirmed/" + orderNo + "/confirmed";
		                    $.post(url, function (res) {
		                        if (res === 'success') {
		                            $btn.text('오늘 픽업')
		                                .css({ 'background-color': '#D8A8AB', 'color': '#fff', 'border': '1px solid #D8A8AB' })
		                                .attr('data-status', 'today');
		                            $parentCard.find('.order-btn-pickup').css({
		                                'text-decoration': 'none',
		                                'color': 'inherit'
		                            });
		                        } else {
		                            alert('오늘픽업으로 복귀 실패');
		                            $(this).prop('checked', true);
		                        }
		                    }).fail(() => {
		                        alert("ajax 실패");
		                        $(this).prop('checked', true);
		                    });
		                } else {
		                    $(this).prop('checked', true);
		                }
		            } else {
		                alert("픽업 시간이 초과되었습니다.");
		                $(this).prop('checked', true);
		            }
		        }else {
					alert('픽업 시간이 아닙니다.');
		        	if(isChecked) {
		        		$(this).prop('checked', false);
		        	}else {
		        		$(this).prop('checked', true);
		        	}
		        	$(this).siblings('.checkbox-img').css({
		        	    'pointer-events': 'none',
		        	    'opacity': 1
		        	});
		        	$(this).prop('disabled', true);
		        }
		    });
		});
    </script>