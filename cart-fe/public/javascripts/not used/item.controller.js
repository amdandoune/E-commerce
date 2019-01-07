(function () {
    var app = angular.module("itemsModule");
    app.controller("ItemCtrl", ItemCtrl);

    function ItemCtrl($scope,ItemDataSvc) {
        // $scope.name="akash";
        ItemDataSvc.getItems().then(function (data) {
            // console.log("ItemCtrl data: " +JSON.stringify(data));
            // $scope.
                self.shopitems = data;
        });

        var self = this;
        self.editMode = false;
        self.addMode = false;

        self.selectItem = function(index){
            self.selectedItem = self.shopitems[index];
            self.successMessage = undefined;
            self.errorMessage = undefined;
        }

        self.toggleEditMode = function (){
            self.editMode = ! self.editMode;
        }

        self.saveItem = function () {
            self.toggleEditMode();
            var itemData = self.selectedItem;

            if(self.addMode){
                ItemDataSvc.createItem(itemData)
                    .then(function () {
                            self.successMessage = "Data successfully updated";
                            console.log("Data successfully added " );
                        },
                        function () {
                            self.errorMessage = "There was an error. Please try again.";
                            console.log("Data error for added " );
                        });
                self.addMode = false;
            }
            else {
                ItemDataSvc.saveItem(itemData)
                    .then(function () {
                            self.successMessage = "Data successfully updated";
                            console.log("Data successfully updated " );
                        },
                        function () {
                            self.errorMessage = "There was an error. Please try again.";
                            console.log("Data error for updated " );
                        });
            }
            $window.location.reload();

        }

        self.addItem = function () {
            self.addMode = true;
            var idvalue = self.shopitems.length+1;

            self.selectedItem = {
                "id": idvalue,
                "inventoryID": 1
            }
            self.editMode = true;
        }

        self.removeItem = function () {
            var itemData = self.selectedItem;
            ItemDataSvc.deleteItem(itemData)
                .then(function () {
                        self.successMessage = "Data successfully removed";
                        console.log("Data successfully removed " );
                    },
                    function () {
                        self.errorMessage = "There was an error. Please try to delete again.";
                        console.log("Data error for delete " );
                    });
            $window.location.reload();
        }
    }
})();