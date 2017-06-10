package com.example.examplemod;
import java.util.Map;

public class Template {
    private String name;
    private String[] layers;
    private Map<String,String> symbols;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getLayer(int layer) {
        return layers[layer].split("\n");
    }
    public String[] getLayers() {
        return layers;
    }
    public void setLayers(String[] roles) {
        this.layers = roles;
    }
    public Map<String,String> getSymbols() {
        return this.symbols;
    }
    public void setSymbols(Map<String,String> symbols) {
        this.symbols = symbols;
    }


}
