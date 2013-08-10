//
//  MGMHomeViewController.h
//  Music Geek Monthly
//
//  Created by Ceri Hughes on 04/07/2013.
//  Copyright (c) 2013 Ceri Hughes. All rights reserved.
//

#import "MGMAbstractEventController.h"

typedef enum
{
    MGMHomeViewControllerOptionPreviousNone = 0,
    MGMHomeViewControllerOptionPreviousEvents = 1,
    MGMHomeViewControllerOptionCharts = 2
}
MGMHomeViewControllerOption;

@protocol MGMHomeViewControllerDelegate <NSObject>

- (void) optionSelected:(MGMHomeViewControllerOption)option;

@end

@interface MGMHomeViewController : MGMAbstractEventController

@property (weak) id<MGMHomeViewControllerDelegate> delegate;

@end
