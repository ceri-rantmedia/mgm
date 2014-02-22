//
//  MGMRemoteXmlDataSource.m
//  MusicGeekMonthly
//
//  Created by Ceri Hughes on 22/02/2014.
//  Copyright (c) 2014 Ceri Hughes. All rights reserved.
//

#import "MGMRemoteXmlDataSource.h"

@implementation MGMRemoteXmlDataSource

- (MGMRemoteData*) convertRemoteData:(NSData *)remoteData key:(id)key
{
    NSDictionary* xml = nil;
    if (remoteData)
    {
        NSError* xmlError = nil;
        xml = [MGMXmlParser dictionaryForXMLData:remoteData error:&xmlError];
        if (xmlError)
        {
            return [MGMRemoteData dataWithError:xmlError];
        }
    }
    return [self convertXmlData:xml key:key];
}

@end

@implementation MGMRemoteXmlDataSource (Protected)

- (MGMRemoteData*) convertXmlData:(NSDictionary*)xml key:(id)key
{
    return nil;
}

@end