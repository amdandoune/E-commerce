
var myApp = angular.module('itemsModule', ['ui.router']);


// part of the code to remove the # from the url
myApp.config(['$locationProvider', function($locationProvider) {
    // $locationProvider.hashPrefix(''); // by default '!'
    $locationProvider.html5Mode(true);
}]);


myApp.config(function($stateProvider) {
    // An array of state definitions
    var states = [
        { name: 'home', url: '/home', component: 'home' },
        { name: 'about', url: '/about', component: 'about' },

        {
            name: 'itemsAdmin',
            url: '/itemsAdmin',
            templateUrl: '/pages/admin/itempage.html',
            // component: 'items',
            resolve: {
                itemsAdmin: 'ItemsService'
            },
            controller: 'ItemCtrl'

        },

        // {
        //     name: 'itemsAdmin/item',
        //     url: 'itemId',
        //     component: 'item',
        //     resolve:{
        //         item:function(items, $stateParams) {
        //             return itemsAdmin.find(function (item) {
        //                 return item.id === $stateParams.itemId;
        //             });
        //         }
        //     }
        // },

        {
            name: 'items',
            url: '/items',
            templateUrl: '/pages/user/itempage.html',
            // component: 'items',
            resolve: {
                items: 'ItemsService'
            },
            controller: 'ItemCtrl'
        },

        {
            name: 'itemsReview',
            url: '/itemsReview',
            templateUrl: '/pages/admin/itemsreview.html',
            // component: 'itemsReview',
            resolve: {
                items: 'ItemsService'
            },
            controller: 'ItemCtrl'
        }

        // {
        //     name: 'people.person',
        //     url: '/{personId}',
        //     component: 'person',
        //     resolve: {
        //         person: function(people, $stateParams) {
        //             return people.find(function(person) {
        //                 return person.id === $stateParams.personId;
        //             });
        //         }
        //     }
        // }
    ]

    // Loop over the state definitions and register them
    states.forEach(function(state) {
        $stateProvider.state(state);
    });
});