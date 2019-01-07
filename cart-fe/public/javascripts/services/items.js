angular.module('itemsModule').service('ItemsService', function($http) {
    var service = {
        getAllItems: function() {
            return $http.get('http://localhost:8080/items').then(function(resp) {
                // console.log(resp);
                return resp.data;
            });
        },

        getItem: function(id) {
            function itemMatchesParam(item) {
                return item.id === id;
            }

            return service.getAllItems().then(function (items) {
                return items.find(itemMatchesParam)
            });
        },

        saveItem: function(itemData,callback){
            $http.put('http://localhost:8080/items/'+ itemData.id, itemData)
                .then(function (response) {
                    console.log(response);
                    callback();
                });
        },

        createItem: function(itemData,callback){
            $http.post('http://localhost:8080/items', itemData)
                .then(function (response) {
                    console.log(response);
                    callback();
                });
        },

        deleteItem: function(itemData,callback){
            $http.delete('http://localhost:8080/items/'+ itemData.id)
                .then(function (response) {
                    console.log(response);
                    callback();
                });
        },

        getAllReviews: function() {
            return $http.get('http://localhost:8080/reviews').then(function(resp) {
                // console.log(resp);
                return resp.data;
            });
        },

    }

    return service;
})