package com.web.srv;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class ListEqualsFilesHolder {

    private Map<String,String> listEqualsFiles = new HashMap<>();

    public Map<String, String> getListEqualsFiles() {
        return listEqualsFiles;
    }

    public void setListEqualsFiles(Map<String, String> listEqualsFiles) {
        this.listEqualsFiles = listEqualsFiles;
    }
}
