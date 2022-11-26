package com.r2g.msproduct.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter @Setter @Builder
public class ErrorMenssage {
    private String code;
    private List<Map<String,String>> messages;
}
