package com.betting.bettinginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableCaching
public class BettingInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BettingInfoApplication.class, args);

	/*	String packageName = "com.betting.bettinginfo.jsontojavaclass.pojo";
		String baseInputPath = "src/main/resources";
		String baseOutputPath = "src/main/java";

		File inputJson = new File(baseInputPath + File.separator + "input.json");
		File outputPojoDirectory = new File(baseOutputPath *//*+ File.separator  + "convertedPojo"*//*);
		outputPojoDirectory.mkdirs();
		try {
			convertJsonToJavaClass(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));
		} catch (IOException e) {
			System.out.println("Encountered issue while converting to pojo: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName) throws IOException {
		JCodeModel jcodeModel = new JCodeModel();

		GenerationConfig config = new CustomGenerationConfig();

		SchemaMapper
				mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

		jcodeModel.build(outputJavaClassDirectory);*/
	}


}
