angular.module('app').controller('storeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

     $scope.fillTable = function (pageIndex = 1) {
         $http({
             url: contextPath + '/api/v1/products',
             method: "GET",
             params: {
                        title: $scope.filterObj ? $scope.filterObj.title : null,
                        min_price: $scope.filterObj ? $scope.filterObj.min_price : null,
                        max_price: $scope.filterObj ? $scope.filterObj.max_price : null,
                        p: pageIndex
             }
         }).then(function (response) {
             $scope.ProductsPage=response.data;
             $scope.PaginationArray = $scope.generatePagesInd(1, $scope.ProductsPage.totalPages);
         });
     }

    $scope.addToCart = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/add/' + productId,
            method: 'GET'
        }).then(function (response) {
            console.log('added to cart: ' + productId);
//            alert('Товар добавлен!');
        });
    }

     $scope.generatePagesInd = function(startPage, endPage) {
             let arr = [];
             for (let i = startPage; i < endPage + 1; i++) {
                 arr.push(i);
             }
             return arr;
         }

    $scope.fillTable();
});