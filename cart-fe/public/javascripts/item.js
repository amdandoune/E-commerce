angular.module('itemsModule').component('item',{
    bindings: { itemsAdmin: '<'},
    template: '<div class="row">\n' +
    '            <div class="media">\n' +
    '                <div class="media-body">\n' +
    '                    <button >Add</button>\n' +
    '                    <!--ng-click="ctrl.addItem()"-->\n' +
    '                    <!--<button ng-hide="ctrl.editMode" ng-click="ctrl.toggleEditMode()">Edit</button>-->\n' +
    '                    <!--<button ng-show="ctrl.editMode" ng-click="ctrl.saveItem()" onclick="document.location.reload(true)">Save</button>-->\n' +
    '                    <!--<button ng-click="ctrl.removeItem()" onclick="document.location.reload(true)">Delete</button>-->\n' +
    '                    <!---->\n' +
    '                    <!--<div ng-if="ctrl.successMessage" class="alert alert-success">{{ ctrl.successMessage }}</div>-->\n' +
    '                    <!--<div ng-if="ctrl.errorMessage" class="alert alert-danger">{{ ctrl.errorMessage }}</div>-->\n' +
    '\n' +
    '                    <p><span>ID:</span><span>{{ " "+ ctrl.item.id }}</span></p>\n' +
    '                    <p><span>Name:</span><span ng-hide="ctrl.editMode">{{ " "+ ctrl.item.name }}</span>\n' +
    '                        <input type="text" ng-show="ctrl.editMode" ng-model="ctrl.item.name"/>\n' +
    '                    </p>\n' +
    '                    <p><span>Type:</span><span ng-hide="ctrl.editMode">{{ " "+ ctrl.item.type }}</span>\n' +
    '                        <input type="text" ng-show="ctrl.editMode" ng-model="ctrl.item.type"/>\n' +
    '                    </p>\n' +
    '                    <p><span>Quantity:</span><span ng-hide="ctrl.editMode">{{ " "+ ctrl.item.quantity }}</span>\n' +
    '                        <input type="number" ng-show="ctrl.editMode" ng-model="ctrl.selectedItem.quantity"/>\n' +
    '                    </p>\n' +
    '                    <p><span>Price:</span><span ng-hide="ctrl.editMode">{{ " "+ ctrl.item.price }}</span>\n' +
    '                        <input type="number" ng-show="ctrl.editMode" ng-model="ctrl.item.price"/>\n' +
    '                    </p>\n' +
    '                    <p><span>Seller:</span><span ng-hide="ctrl.editMode">{{ " "+ ctrl.item.seller }}</span>\n' +
    '                        <input type="text" ng-show="ctrl.editMode" ng-model="ctrl.item.seller"/>\n' +
    '                    </p>\n' +
    '                    <p><span>Inventory ID:</span><span>{{ " "+ ctrl.item.inventoryID }}</span></p>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>' +

    '<button ui-sref="people">Close</button>'
});