package com.example.exp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XML_JSON extends AppCompatActivity {
    TextView xmltxt,jsontxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_xml_json);
        xmltxt=(TextView) findViewById(R.id.textView5);
        jsontxt=(TextView) findViewById(R.id.textView6);

        Intent intent = getIntent();
        String datatype= intent.getStringExtra("datatype");

        if(datatype.equals("xml")) { xmltxt.setText("XML Parsed "); parsexml();
        }
        else if(datatype.equals("json")) { jsontxt.setText("JSON Parsed"); parsejson();
        }
    }

    private void parsejson() { try {
        InputStream istream = getAssets().open("weather.json");
        byte[] data = new byte[istream.available()]; istream.read(data);
        String jsonstr=new String(data); JSONObject jobj=new JSONObject(jsonstr);
        JSONObject weather = jobj.getJSONObject("weather");

        jsontxt.setText("city_name:"+weather.getString("city_name")+"\n");
        jsontxt.append("latitude: "+weather.getString("latitude")+"\n");
        jsontxt.append("longitude: "+weather.getString("longitude")+"\n");
        jsontxt.append("temperature: "+weather.getString("temperature")+"\n");
        jsontxt.append("humidity: "+weather.getString("humidity"));


    } catch (IOException | JSONException e) { e.printStackTrace();
    }
    }

    private void parsexml() { try {
        InputStream istream = getAssets().open("weather.xml"); DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance(); DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = ((DocumentBuilder) db).parse(istream); doc.normalize();
        NodeList nlist = doc.getElementsByTagName("weather");
        for(int i = 0; i<nlist.getLength(); i++) {
            Node node=nlist.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element ele = (Element) node;
                xmltxt.setText("city_name: "+ ele.getElementsByTagName("city_name").item(0).getTextContent()+"\n");
                xmltxt.append("latitude: "+ ele.getElementsByTagName("latitude").item(0).getTextContent()+"\n");
                xmltxt.append("longitude: "+ ele.getElementsByTagName("longitude").item(0).getTextContent()+"\n");
                xmltxt.append("temperature: "+ ele.getElementsByTagName("temperature").item(0).getTextContent()+"\n");
                xmltxt.append("humidity: "+ ele.getElementsByTagName("humidity").item(0).getTextContent());
            }
        }

    } catch (IOException | ParserConfigurationException | SAXException e)
    {
        e.printStackTrace();
    }
    }
}