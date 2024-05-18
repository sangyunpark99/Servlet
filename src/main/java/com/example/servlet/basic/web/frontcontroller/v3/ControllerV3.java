package com.example.servlet.basic.web.frontcontroller.v3;

import com.example.servlet.basic.web.frontcontroller.ModelView;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
