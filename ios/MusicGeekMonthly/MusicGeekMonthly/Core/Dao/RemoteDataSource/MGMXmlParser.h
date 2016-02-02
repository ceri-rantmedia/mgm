//
//  MGMXmlParser.h
//  MusicGeekMonthly
//
//  Created by Ceri Hughes on 22/02/2014.
//  Copyright (c) 2014 Ceri Hughes. All rights reserved.
//

@import Foundation;

#define MGM_XMLReader_TextNodeKey @"text"

@interface MGMXmlParser : NSObject

+ (NSDictionary*) dictionaryForXMLData:(NSData*)data error:(NSError**)error;

@end
