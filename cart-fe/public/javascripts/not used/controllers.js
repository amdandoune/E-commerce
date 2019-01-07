var app = angular.module('itemsModule');

app.controller('ItemsAdminCtrl',
    ['$scope', 'itemsAdmin',
        function ($scope, itemsAdmin) {
            $scope.itemsAdmin = itemsAdmin;
        }]);

app.controller('ItemsAdminCtrl',
    ['$scope', 'itemsAdd',
        function ($scope, itemsAdd) {
            $scope.itemsAdd = itemsAdd;
        }]);


app.controller('ItemsCtrl',
    ['$scope', 'items',
        function ($scope, items) {
            $scope.items = items;
        }]);