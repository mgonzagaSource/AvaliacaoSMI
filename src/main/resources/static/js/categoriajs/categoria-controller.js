appLancamentosGlobal.controller("categoriaController", function($scope, $http, $window) {

	$scope.categorias = [];
	$scope.categoria = {};

	$scope.msg = '';

	url = 'http://localhost:8080/categorias/';

	$scope.listarCategorias = function() {
		$http({
			method : 'GET',
			url : url,
		}).then(function(response) {
			$scope.categorias = response.data;
			console.log(response.data);
		}, function() {

		});
	}

	$scope.salvarCategoria = function() {
		$http({
			method : 'POST',
			url : url,
			data : $scope.categoria
		}).then(function(response) {
			$scope.categorias = response.data;
			// console.log(response.data);
			$scope.msg = 'categoria cadastrada com sucesso';
			$scope.categoria = {};
			$scope.exibeMensagem($scope.msg);
			$scope.categForm.$setPristine();
		}, function() {
			$scope.msg = 'erro ao cadastrar';
			$scope.exibeMensagem($scope.msg);
		});
	}

	$scope.excluirCategoria = function(categoria) {
		$http({
			method : 'DELETE',
			url : url + categoria.id,
			data : $scope.categoria
		}).then(function(response) {
			$scope.categorias = response.data;
			$scope.msg = 'categoria exluida com sucesso';
			$scope.exibeMensagem($scope.msg);
			$scope.listarCategorias();
			console.log(response.data);
		}, function() {
			$scope.msg = 'Erro ao exluir';
			$scope.exibeMensagem($scope.msg);
		});
	}

	$scope.exibeMensagem = function(strmsg) {

		$window.alert(strmsg);
	}

	$scope.listarCategorias();
});