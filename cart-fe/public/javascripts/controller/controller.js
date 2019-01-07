var app = angular.module("itemsModule");
app.controller("ItemCtrl", ItemCtrl);
app.controller("ReviewCtrl", ReviewCtrl);

function ItemCtrl($scope,ItemsService) {
    // $scope.name="akash";
    ItemsService.getAllItems().then(function (data) {
        // console.log("ItemCtrl data: " +JSON.stringify(data));
        // $scope.
        self.shopitems = data;
    });

    var self = this;
    self.editMode = false;
    self.addMode = false;
    // self.viewMode = false;

    self.selectItem = function(index){
        self.selectedItem = self.shopitems[index];
        self.successMessage = undefined;
        self.errorMessage = undefined;
        // self.viewMode = true;
    }

    self.toggleEditMode = function (){
        self.editMode = ! self.editMode;
    }

    self.saveItem = function () {
        self.toggleEditMode();
        var itemData = self.selectedItem;

        if(self.addMode){
            ItemsService.createItem(itemData, function () {
                    ItemsService.getAllItems().then(function (data) {
                        self.shopitems = data;
                    });
                });
                // .then(function () {
                //         // self.successMessage = "Data successfully updated";
                //         console.log("Data successfully added " );
                //     },
                //     function () {
                //         // self.errorMessage = "There was an error. Please try again.";
                //         console.log("Data error for added " );
                //     });
            self.addMode = false;
        }
        else {
            ItemsService.saveItem(itemData, function () {
                    ItemsService.getAllItems().then(function (data) {
                        self.shopitems = data;
                    });
                });
                // .then(function () {
                //         // self.successMessage = "Data successfully updated";
                //         console.log("Data successfully updated " );
                //     },
                //     function () {
                //         // self.errorMessage = "There was an error. Please try again.";
                //         console.log("Data error for updated " );
                //     });
        }
        // $window.location.reload();
        // self.viewMode = false;

    }

    self.addItem = function () {
        self.addMode = true;
        // var idvalue = self.shopitems[self.shopitems.length-1].id + 1;

        self.selectedItem = {
            // "id": idvalue,
            "inventoryID": 1
        }
        self.editMode = true;
    }

    self.removeItem = function () {
        var itemData = self.selectedItem;
        ItemsService.deleteItem(itemData, function () {
            ItemsService.getAllItems().then(function (data) {
                self.shopitems = data;
            });
        });
            // .then(function () {
            //         // self.successMessage = "Data successfully removed";
            //         console.log("Data successfully removed " );
            //     },
            //     function () {
            //         // self.errorMessage = "There was an error. Please try to delete again.";
            //         console.log("Data error for delete " );
            //     });
        // $window.location.reload();
        // self.viewMode = false;
    }

    // ItemsService.getAllReviews().then(function (data) {
    //     // console.log("ItemCtrl data: " +JSON.stringify(data));
    //     // $scope.
    //     self.itemsreviews = data;
    // });
}

function ReviewCtrl($scope,ReviewService) {


    var self = this;
    self.editModeReview = false;
    self.addModeReview = false;
    // self.selectedReview
    // this.selectedReview
    ReviewService.getAllReviews().then(function (data) {
        console.log("ItemCtrl selected review: " +JSON.stringify(self.selectedReview));
        // console.log("ItemCtrl data: " +JSON.stringify(data));
        self.itemsreviews = data;
    });


    self.selectReview = function(index){
        self.selectedReview = self.itemsreviews[index];
    }

    self.toggleEditModeReview = function (){
        self.editModeReview = ! self.editModeReview;
    }

    self.saveReview = function () {
        self.toggleEditModeReview();
        var data = self.selectedReview;

        if(self.addModeReview){
            ReviewService.createReview(data, function () {
                ReviewService.getAllReviews().then(function (data) {
                    self.itemsreviews = data;
                });
            });
            console.log("In save Review add ctrl: " +JSON.stringify(data));
            self.addModeReview = false;
        }
        else {
            ReviewService.saveReview(data, function () {
                ReviewService.getAllReviews().then(function (data) {
                    self.itemsreviews = data;
                });
            });
            console.log("In save Review save ctrl: " +JSON.stringify(data));

        }
    }

    self.addReview = function () {
        self.addModeReview = true;
        // var idvalue = self.itemsreviews.length+1;
        // console.log("In add Review ctrl: " +self.selectedItem.id);
        self.selectedReview = {
            // "id": idvalue,
            // "item.id": self.selectedItem.id
        }
        self.editModeReview = true;
    }

    self.removeReview = function () {
        var data = self.selectedReview;
        ReviewService.deleteReview(data, function () {
            ReviewService.getAllReviews().then(function (data) {
                self.itemsreviews = data;
            });
        });
    }

}