package com.googlecode.openrest.v1_1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;

/**
 * The openrest client for a multi-restaurant site.
 * @author DL
 */
public class OpenrestClient {
    private final URL apiUrl;
    private final String accessToken;
    private final OpenrestProtocol protocol;
    
    public OpenrestClient(URL apiUrl, String accessToken, Integer connectTimeout, Integer readTimeout) {
        this.apiUrl = apiUrl;
        this.accessToken = accessToken;
        protocol = new OpenrestProtocol(connectTimeout, readTimeout);
    }
    
    public OpenrestClient(URL apiUrl, String accessToken) {
    	this(apiUrl, accessToken, null, null);
    }

    public OpenrestClient(URL restaurantUrl) {
        this(restaurantUrl, null);
    }
    
    public RestaurantClient getRestaurantClient(String restaurantId) {
    	try {
    		return new RestaurantClient(new URL(apiUrl.toString() + "/restaurants/" + restaurantId), accessToken, protocol);
    	} catch (MalformedURLException e) {
    		throw new RuntimeException(e);
    	}
    }
    
    public DistributorClient getDistributorClient(String distributorId) {
    	try {
    		return new DistributorClient(new URL(apiUrl.toString() + "/distributors/" + distributorId), accessToken, protocol);
    	} catch (MalformedURLException e) {
    		throw new RuntimeException(e);
    	}
    }

    ///////////////////////////////////////////////////////////////////////////
    
    public List<Distributor> getDistributors(List<String> distributorIds) throws IOException, OpenrestException {
    	final QueryStringBuilder query = new QueryStringBuilder();
    	query.append("ids", distributorIds);
    	
        return protocol.get(new URL(apiUrl + "/distributors/" + query.toString()), new TypeReference<Response<List<Distributor>>>() {});
    }
    
    public Distributor addDistributor(Distributor distributor) throws IOException, OpenrestException {
    	final QueryStringBuilder query = new QueryStringBuilder();
    	query.append("access_token", accessToken);
    	
        return protocol.add(new URL(apiUrl + "/distributors/" + query.toString()), distributor, new TypeReference<Response<Distributor>>() {});
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    public List<Restaurant> getRestaurants(List<String> restaurantIds) throws IOException, OpenrestException {
    	final QueryStringBuilder query = new QueryStringBuilder();
    	query.append("ids", restaurantIds);
    	
        return protocol.get(new URL(apiUrl + "/restaurants/" + query.toString()), new TypeReference<Response<List<Restaurant>>>() {});
    }
    
    public Restaurant addRestaurant(Restaurant restaurant) throws IOException, OpenrestException {
    	final QueryStringBuilder query = new QueryStringBuilder();
    	query.append("access_token", accessToken);
    	
        return protocol.add(new URL(apiUrl + "/restaurants/" + query.toString()), restaurant, new TypeReference<Response<Restaurant>>() {});
    }
    
    public List<RestaurantFullInfo> getRestaurantsFullInfo(List<String> restaurantIds) throws IOException, OpenrestException {
    	final QueryStringBuilder query = new QueryStringBuilder();
    	query.append("ids", restaurantIds);
    	
        return protocol.get(new URL(apiUrl + "/restaurants.full/" + query.toString()), new TypeReference<Response<List<RestaurantFullInfo>>>() {});
    }
    
    public Map<String, Menu> getMenus(List<String> restaurantIds) throws IOException, OpenrestException {
    	final QueryStringBuilder query = new QueryStringBuilder();
    	query.append("restaurantIds", restaurantIds);
    	
        return protocol.get(new URL(apiUrl + "/menus/" + query.toString()), new TypeReference<Response<Map<String, Menu>>>() {});
    }
}