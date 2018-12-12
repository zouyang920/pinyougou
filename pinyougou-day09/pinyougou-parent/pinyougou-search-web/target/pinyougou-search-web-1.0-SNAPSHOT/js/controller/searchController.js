app.controller('searchController', function($scope, searchService) {

    $scope.searchMap = {'keywords':'','category':'', 'brand':'', 'spec':{}, 'price':'', 'pageNo':1, 'pageSize':20, 'sort':'1', 'sortField':''};
    $scope.search=function() {

        searchService.search( $scope.searchMap).success(function (response) {

            $scope.resultMap = response;
            console.log($scope.resultMap);
        });
    }

});