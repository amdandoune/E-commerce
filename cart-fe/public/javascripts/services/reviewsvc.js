angular.module('itemsModule').service('ReviewService', function($http) {
    var service = {

        getAllReviews: function() {
            // items/'+ itemId.item.id +'/
            return $http.get('http://localhost:8080/reviews').then(function(resp) {
                // console.log("Review id: "+itemId.id);
                // console.log(" Review item id: "+ itemId.item.id);
                return resp.data;
            });
        },

        // getAllReviews: function(itemId) {
        //     // items/'+ itemId.item.id +'/
        //     return $http.get('http://localhost:8080/items/'+ itemId.item.id +'/reviews').then(function(resp) {
        //         // console.log("Review id: "+itemId.id);
        //         // console.log(" Review item id: "+ itemId.item.id);
        //         return resp.data;
        //     });
        // },

        saveReview: function(data){
            console.log("Save selected: "+data.id);
            $http.put('http://localhost:8080/reviews/'+ data.id, data)
                .then(function (response) {
                    console.log(response);
                    // callback();
                });
        },

        createReview: function(data, callback){
            console.log("Create selected: "+JSON.stringify(data));
            $http.post('http://localhost:8080/reviews', data)
                .then(function (response) {
                    console.log(response);
                    callback();
                });
        },

        deleteReview: function(data, callback){
            console.log(data.id);
            $http.delete('http://localhost:8080/reviews/'+ data.id)
                .then(function (response) {
                    console.log(response);
                    callback();
                });
        },


    }

    return service;
})