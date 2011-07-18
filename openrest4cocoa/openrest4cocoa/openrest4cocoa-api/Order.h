//
//  Order.h
//  openrest4cocoa
//
//  Created by Yoav Amit on 5/4/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Delivery.h"
#import "Contact.h"
#import "User.h"

#define ORDER_STATUS_PENDING    @"pending"
#define ORDER_STATUS_NEW        @"new"
#define ORDER_STATUS_ACCEPTED   @"accepted"
#define ORDER_STATUS_CANCELLED  @"canceled"

@interface Order : NSObject {
    
    /** The order's unique id. */
    NSString* orderId;
    
    /** The restaurant's unique id. */
    NSString* restaurantId;
    
    /** The ordered items. */
    NSArray* orderItems;
    
    /** Comment to the restaurant (as opposed to the delivery person!). */
    NSString* comment;
    
    /** Total price of the order. */
    int price;
    
    /* Delivery method. */
    Delivery* delivery;
    
    /* Contact details. */
    Contact* contact;
    
    /* Payments. */
    NSArray* payments;
    
    /** The order's creation timestamp. */
    NSNumber* created;
    
    /** The order's last modification timestamp. */
    NSNumber* modified;
    
    /** The ordering user. */
    User* user;
    
    /** The order's status. */
    NSString* status;
    
    /** The order's share-token. */
    NSString* shareToken;
    
    /** The order's takeout packs */
    NSNumber* takeoutPacks;
    
    /** Extra charges or discounts */
    NSArray* charges;
}

@property (nonatomic, retain) NSString* orderId;
@property (nonatomic, retain) NSString* restaurantId;
@property (nonatomic, retain) NSArray* orderItems;
@property (nonatomic, retain) NSString* comment;
@property (nonatomic) int price;
@property (nonatomic, retain) Delivery* delivery;
@property (nonatomic, retain) Contact* contact;
@property (nonatomic, retain) NSArray* payments;
@property (nonatomic, retain) NSNumber* created;
@property (nonatomic, retain) NSNumber* modified;
@property (nonatomic, retain) User* user;
@property (nonatomic, retain) NSString* status;
@property (nonatomic, retain) NSString* shareToken;
@property (nonatomic, retain) NSNumber* takeoutPacks; 
@property (nonatomic, retain) NSArray* charges;

-(id)init;
-(id)initWithDictionary:(NSDictionary*)data;

-(int)getDeliveryPrice;

-(NSDictionary*)proxyForJson;

-(NSComparisonResult)compareByDate:(Order*)other;

@end
