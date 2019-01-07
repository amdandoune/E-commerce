// var app = angular.module("itemsModule");
app.controller("ReviewCtrl", ReviewCtrl);

function ReviewCtrl($scope,ReviewService) {

    ItemsService.getAllReviews().then(function (data) {
        // console.log("ItemCtrl data: " +JSON.stringify(data));
        self.itemsreviews = data;
    });

    var self = this;
    self.editModeReview = false;
    self.addModeReview = false;

    // self.selectItem = function(index){
    //     self.selectedItem = self.shopitems[index];
    // }

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
                ItemsService.getAllReviews().then(function (data) {
                    self.itemsreviews = data;
                });
            });
            self.addModeReview = false;
        }
        else {
            ReviewService.saveReview(data, function () {
                ItemsService.getAllReviews().then(function (data) {
                    self.itemsreviews = data;
                });
            });
        }
    }

    self.addReview = function () {
        self.addModeReview = true;
        // var idvalue = self.itemsreviews.length+1;

        self.selectedReview = {
            // "id": idvalue,
            "item.id": self.selectedItem.id
        }
        self.editModeReview = true;
    }

    self.removeReview = function () {
        var data = self.selectedReview;
        ReviewService.deleteReview(data, function () {
            ItemsService.getAllReviews().then(function (data) {
                self.itemsreviews = data;
            });
        });
    }

}