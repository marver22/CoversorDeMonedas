package com.marver.conversor.modulos;

public record MonedaAPI(String base_code,
                        String target_code,
                        double conversion_rate,
                        double conversion_result) {
}
