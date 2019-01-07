(function(){
    var app = angular.module("itemsModule");

    app.service("ItemsService", function ($http) {

        var self = this;
        self.getItems = function() {
            // console.log("calling API");
            var promise1 = $http.get('http://localhost:8080/items');
            var promise2 = promise1.then(function (response) {
                // console.log("RESPONSE:"+JSON.stringify(response.data));
                return response.data;
            });
            return promise2;
        }

        self.saveItem = function(itemData){
            $http.put('http://localhost:8080/items/'+ itemData.id, itemData)
                .then(function (response) {
                    console.log(response);
                });
        }

        self.createItem = function(itemData){
            $http.post('http://localhost:8080/items', itemData)
                .then(function (response) {
                    console.log(response);
                });
        }

        self.deleteItem = function(itemData){
            $http.delete('http://localhost:8080/items/'+ itemData.id)
                .then(function (response) {
                    console.log(response);
                });
        }
    })
})();