package kr.co.ohgoodfood.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class StoreSales {
    private String store_id;
    private int sales;
    private String start_date;
    private String end_date;
    private String s_type;
    private String s_value;

}
