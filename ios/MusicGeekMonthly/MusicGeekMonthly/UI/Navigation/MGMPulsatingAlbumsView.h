//
//  MGMPulsatingAlbumsView.h
//  Music Geek Monthly
//
//  Created by Ceri Hughes on 23/07/2013.
//  Copyright (c) 2013 Ceri Hughes. All rights reserved.
//

#import "MGMView.h"

@import UIKit;

@interface MGMPulsatingAlbumsView : MGMView

@property (readonly) NSUInteger albumCount;
@property (readonly) CGSize albumSize;

- (void) setupAlbumsInRow:(NSUInteger)albumsInRow;
- (void) renderImage:(UIImage*)image atIndex:(NSUInteger)index animation:(BOOL)animation;

@end
