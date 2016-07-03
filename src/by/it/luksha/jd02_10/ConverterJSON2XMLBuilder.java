package by.it.luksha.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class ConverterJSON2XMLBuilder extends AbstractConverter{

    public ConverterJSON2XMLBuilder(Class beanClass) {
        super(beanClass);
    }

    public ConverterJSON2XMLBuilder(Object bean) {
        super(bean);
    }

    //построение по данным из строки
    @Override
    public void buildConverter(String txtData) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(txtData, getBeanClass());
    }

    //запись результата в строку
    @Override
    public String getConverterResult() {
        JAXBContext jc = null;
        StringWriter stringWriter = new StringWriter();
        try {
            jc = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(getBean(), stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }
}
