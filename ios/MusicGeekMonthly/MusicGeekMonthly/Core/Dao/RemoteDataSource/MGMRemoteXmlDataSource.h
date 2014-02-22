//
//  MGMRemoteXmlDataSource.h
//  MusicGeekMonthly
//
//  Created by Ceri Hughes on 22/02/2014.
//  Copyright (c) 2014 Ceri Hughes. All rights reserved.
//

#import "MGMRemoteDataSource.h"

#import "MGMXmlParser.h"

@interface MGMRemoteXmlDataSource : MGMRemoteDataSource

@end

@interface MGMRemoteXmlDataSource (Protected)

#pragma mark -
#pragma mark Override the following

- (MGMRemoteData*) convertXmlData:(NSDictionary*)xml key:(id)key;

@end
