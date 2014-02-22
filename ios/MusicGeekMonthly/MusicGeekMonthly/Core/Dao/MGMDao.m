//
//  MGMDao.m
//  MusicGeekMonthly
//
//  Created by Ceri Hughes on 15/02/2014.
//  Copyright (c) 2014 Ceri Hughes. All rights reserved.
//

#import "MGMDao.h"

#import "MGMAllEventsDaoOperation.h"
#import "MGMAllTimePeriodsDaoOperation.h"
#import "MGMCoreDataAccess.h"
#import "MGMPlaylistDaoOperation.h"
#import "MGMWeeklyChartDaoOperation.h"

@interface MGMDao ()

@property (readonly) MGMAllEventsDaoOperation* eventDaoOperation;
@property (readonly) MGMAllTimePeriodsDaoOperation* timePeriodDaoOperation;
@property (readonly) MGMWeeklyChartDaoOperation* weeklyChartDaoOperation;
@property (readonly) MGMPlaylistDaoOperation* playlistDaoOperation;

@end

@implementation MGMDao

- (id) initWithCoreDataAccess:(MGMCoreDataAccess*)coreDataAccess
{
    if (self = [super init])
    {
        _eventDaoOperation = [[MGMAllEventsDaoOperation alloc] initWithCoreDataAccess:coreDataAccess];
        _timePeriodDaoOperation = [[MGMAllTimePeriodsDaoOperation alloc] initWithCoreDataAccess:coreDataAccess];
        _weeklyChartDaoOperation = [[MGMWeeklyChartDaoOperation alloc] initWithCoreDataAccess:coreDataAccess];
        _playlistDaoOperation = [[MGMPlaylistDaoOperation alloc] initWithCoreDataAccess:coreDataAccess];
    }
    return self;
}

- (void) setReachability:(BOOL)reachability
{
    self.eventDaoOperation.reachability = reachability;
    self.timePeriodDaoOperation.reachability = reachability;
    self.weeklyChartDaoOperation.reachability = reachability;
    self.playlistDaoOperation.reachability = reachability;
}

- (MGMDaoData*) fetchAllEvents
{
    return [self.eventDaoOperation fetchData:ALL_EVENTS_KEY];
}

- (MGMDaoData*) fetchAllClassicAlbums
{
    return [self.eventDaoOperation fetchData:ALL_CLASSIC_ALBUMS_KEY];
}

- (MGMDaoData*) fetchAllNewlyReleasedAlbums
{
    return [self.eventDaoOperation fetchData:ALL_NEWLY_RELEASED_ALBUMS_KEY];
}

- (MGMDaoData*) fetchAllEventAlbums
{
    return [self.eventDaoOperation fetchData:ALL_EVENT_ALBUMS_KEY];
}

- (MGMDaoData*) fetchAllTimePeriods
{
    return [self.timePeriodDaoOperation fetchData:nil];
}

- (MGMDaoData*) fetchWeeklyChartForStartDate:(NSDate*)startDate endDate:(NSDate*)endDate
{
    MGMWeeklyChartData* data = [[MGMWeeklyChartData alloc] init];
    data.startDate = startDate;
    data.endDate = endDate;
    return [self.weeklyChartDaoOperation fetchData:data];
}

- (MGMDaoData*) fetchPlaylist:(NSString*)playlistId
{
    return [self.playlistDaoOperation fetchData:playlistId];
}

@end
