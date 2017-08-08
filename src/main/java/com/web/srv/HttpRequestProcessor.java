package com.web.srv;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpRequestProcessor implements Processor {

    final private String listEqualsFiles="etc/com.web.srv.local-web-server.list";

    private ListEqualsFilesHolder listEqualsFilesHolder = new ListEqualsFilesHolder();

    public HttpRequestProcessor() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ListEqualsFilesHolder.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        listEqualsFilesHolder = (ListEqualsFilesHolder) unmarshaller.unmarshal(new File(listEqualsFiles));
    }

    private void setNotFoundPade(Exchange exchange){
        exchange.getOut().setBody("Page not found");
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE,404);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String url=exchange.getIn().getHeader("CamelHttpUrl", String.class);
        String fileName = listEqualsFilesHolder.getListEqualsFiles().get(url);
        if(fileName!=null){
            Path path = Paths.get(fileName);
            if(path.toFile().exists()) {
                byte[] bytes = Files.readAllBytes(Paths.get(fileName));
                exchange.getOut().setBody(bytes);
            }else{
                setNotFoundPade(exchange);
            }
        }else {
            setNotFoundPade(exchange);
        }

    }
}
