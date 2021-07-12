package com.co.belcorp.utilities;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImpexWS {

  private static final Logger log = LoggerFactory.getLogger(ImpexWS.class);
  private static String urlws = System.getProperty("app.url.ws.pyxisautomationapi");
  private static String grantType = System
      .getProperty("app.ws.pyxisautomationapi.oauthdata.grantType");
  private static String clientId = System
      .getProperty("app.ws.pyxisautomationapi.oauthdata.clientId");
  private static String clientSecret = System
      .getProperty("app.ws.pyxisautomationapi.oauthdata.clientSecret");

  private static String getOauthToken() {
    String url = "https://" + urlws + "/authorizationserver/oauth/token";
    Response response = given()
        .relaxedHTTPSValidation()
        .contentType("application/x-www-form-urlencoded")
        .formParam("grant_type", grantType)
        .formParam("client_id", clientId)
        .formParam("client_secret", clientSecret)
        .when()
        .post(url);
    JsonPath jsonPath = response.jsonPath();
    String accessToken = jsonPath.get("access_token");
    return accessToken;
  }

  /**
   * Execute an impex file, located under src/main/resources/impex + (impexDir) + / impexFile
   * impexDir is a CSV where each value is a directory For example: to execute a coupon impex file
   * impexDir should be "promotion,coupon" and impexFile should be "coupon-cl.impex"
   *
   * @param impexDir
   * @param impexFile
   * @return
   */
  public static String executeImpexFile(String impexDir, String impexFile) {
    String url = "https://" + urlws + "/pyxisautomationapi/impex";
    String dir = String.join(File.separator, impexDir.split(","));
    String filePath =
        System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "impex" + File.separator + dir
            + File.separator + impexFile;
    log.info("Impex WS - executeImpexfile: " + filePath);
    Response response = given()
        .relaxedHTTPSValidation()
        .header("Authorization", "Bearer " + getOauthToken())
        .body(new File(filePath))
        .when()
        .post(url);
    response.then().assertThat().statusCode(200);
    JsonPath jsonPath = response.jsonPath();
    String result = jsonPath.get("result");
    String status = jsonPath.get("status");
    log.info("Impex WS - executeImpexfile result: " + result);
    log.info("Impex WS - executeImpexfile status: " + status);
    if ("SUCCESS".equals(result) & "FINISHED".equals(status)) {
      return "1";
    } else {
      return "0";
    }
  }

  public static String cleanCustomerSessionCart(String userEmail) {
    String url = "https://" + urlws + "/pyxisautomationapi/impex";
    String requestBody = "REMOVE Cart[batchmode=true];user(uid)[unique=true]\n" +
        ";" + userEmail;
    log.info("Impex WS - cleanCustomerSessionCart: " + userEmail);
    Response response = given()
        .relaxedHTTPSValidation()
        .header("Authorization", "Bearer " + getOauthToken())
        .body(requestBody)
        .when()
        .post(url);
    response.then().assertThat().statusCode(200);
    JsonPath jsonPath = response.jsonPath();
    String result = jsonPath.get("result");
    String status = jsonPath.get("status");
    log.info("Impex WS - cleanCustomerSessionCart result: " + result);
    log.info("Impex WS - cleanCustomerSessionCart status: " + status);
    if ("SUCCESS".equals(result) & "FINISHED".equals(status)) {
      return "1";
    } else {
      return "0";
    }
  }
}
