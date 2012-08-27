package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Base class for Restaurants, Chains, Distributers, etc.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Organization extends OpenrestObject implements Cloneable {
	private static final long serialVersionUID = 1L;
	
	/** Standard (4:3) logo image. */
    public static final String BLOB_TYPE_LOGO = "logo";
	/** Square (1:1) logo image. */
    public static final String BLOB_TYPE_LOGO_SQUARE = "logo_square";
	/** Standard (4:3) image place holder. */
    public static final String BLOB_TYPE_NO_IMAGE = "no_image";
    
    /** All known blob types. */
    public static final Set<String> ALL_BLOB_TYPES = new HashSet<String>(Arrays.asList(
    		BLOB_TYPE_LOGO, BLOB_TYPE_LOGO_SQUARE, BLOB_TYPE_NO_IMAGE));
	
    /** Default constructor for JSON deserialization. */
    public Organization() {}
    
    protected Organization(String id, Map<String, String> externalIds, Long created, Long modified,
    		Map<String, String> title, Map<String, String> description,
    		String locale, Set<String> locales, ColorScheme colorScheme,
    		Contact contact, Map<String, Contact> externalContacts,
    		Address address, String timezone, 
    		String link, String domain, Set<String> altDomains,
    		List<AppInfo> apps, Seo seo, Map<String, String> properties,
    		String picture, String icon, String noImagePicture) {

    	this.id = id;
    	this.externalIds = externalIds;
    	this.created = created;
    	this.modified = modified;
    	this.title = title;
    	this.description = description;
    	this.locale = locale;
    	this.locales = locales;
    	this.colorScheme = colorScheme;
    	this.contact = contact;
    	this.externalContacts = externalContacts;
    	this.address = address;
    	this.timezone = timezone;
    	this.link = link;
    	this.domain = domain;
    	this.altDomains = altDomains;
    	this.apps = apps;
    	this.seo = seo;
    	this.properties = properties;
    	this.picture = picture;
    	this.icon = icon;
    	this.noImagePicture = noImagePicture;
    }
    
    @Override
	public abstract Object clone();
    
    public java.util.Date created() {
        return ((created != null) ? new java.util.Date(created.longValue()) : null);
    }
    
    public java.util.Date modified() {
        return ((modified != null) ? new java.util.Date(modified.longValue()) : null);
    }
    
    /** The organization's unique id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;
    
    /**
     * Map of externally-defined ids referring to this organization.
     * For example, the organization-id in some external billing system.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> externalIds = new HashMap<String, String>();
    
    /** The organization's creation timestamp. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Long created;
    
    /** The organization's last modification timestamp. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Long modified;
    
    /** The organization's title in various locales. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> title = Collections.emptyMap();

    /** The organization's description or tagline in various locales. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> description = Collections.emptyMap();
    
    /** The color scheme. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public ColorScheme colorScheme;

    /** The organization's contact. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Contact contact;
    
    /**
     * Map of externally-defined contact information for this organization.
     * For example, a redirect phone number in some portal.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, Contact> externalContacts = Collections.emptyMap();

    /** The address of this organization. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Address address;
    
    /**
     * The restaurant's timezone.
     * @see http://en.wikipedia.org/wiki/List_of_tz_database_time_zones
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String timezone;
    
    public TimeZone timezone() {
        return TimeZone.getTimeZone(timezone);
    }
    
    /** The organization's default locale, e.g. "en_US". */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String locale;
    
    /** The organization's supported locales. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Set<String> locales = Collections.emptySet();
    
    /** The organization's main web-site URL. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String link;
    
    /** The organization's online ordering domain. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String domain;
    
    /**
     * The organization's online ordering alternative / legacy domains.
     * These should redirect to the main domain.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Set<String> altDomains = new HashSet<String>(); 
    
    /** The organization's picture URL (direct link), or null if unavailable. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String picture;
    
    /** The organization's icon URL (direct link), or null if unavailable. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String icon;
    
    /** The picture shown when a picture is missing. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String noImagePicture;
    
    /** The organization's applications. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<AppInfo> apps = new ArrayList<AppInfo>();
    
    /** SEO information. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Seo seo;
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> properties = Collections.emptyMap();
}