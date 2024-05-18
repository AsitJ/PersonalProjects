package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProvider {
	
	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException 
	{
        //to convert json file to string format
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);//StandardCharsets is the format in which we want the string file to be encoded
		//to convert json string to HashMap using Jackson Databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		//"data" is a list which has two hashmaps each containing one data set with return or object type as string  {{map},{map1}} in this format
		return data;
		
	}

}
