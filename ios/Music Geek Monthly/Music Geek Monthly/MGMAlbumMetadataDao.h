//
//  MGMAlbumMetadataDao.h
//  Music Geek Monthly
//
//  Created by Ceri Hughes on 02/08/2013.
//  Copyright (c) 2013 Ceri Hughes. All rights reserved.
//

#import "MGMDao.h"
#import "MGMAlbum.h"

@interface MGMAlbumMetadataDao : MGMDao

- (void) updateAlbumInfo:(MGMAlbum*)album;

@end