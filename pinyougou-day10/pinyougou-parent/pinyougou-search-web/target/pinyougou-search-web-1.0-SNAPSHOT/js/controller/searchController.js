app.controller('searchController', function($scope, searchService) {

    $scope.searchMap = {'keywords':'','category':'', 'brand':'', 'spec':{}, 'price':'', 'pageNo':1, 'pageSize':20, 'sort':'1', 'sortField':''};
    $scope.search=function() {

        searchService.search( $scope.searchMap).success(function (response) {

            $scope.resultMap = response;
            console.log($scope.resultMap);
        });
    }

    $scope.addSearchItem=function(key, value) {

        if('category'==key||'brand'==key) {
            $scope.searchMap[key]=value;
        }else {
            $scope.searchMap.spec[key]=value;
        }

        //点击添加搜索选项的时候提交查询
        $scope.search();
    }

    $scope.removeSearchItem=function(key) {

        if('category'==key||'brand'==key) {
            $scope.searchMap[key]='';
        }else {
            delete $scope.searchMap.spec[key];
        }

        //点击撤销搜索选项的时候提交查询
        $scope.search();
    }




});