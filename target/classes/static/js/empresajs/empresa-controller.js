appLancamentosGlobal.controller("empresaController", function($scope, $http, $window) {

	$scope.empresas = [];
	$scope.empresa ={};
	
	$scope.msg = "";
	
	var url = 'http://localhost:8080/empresas/';

	$scope.listarEmpresas = function() {
		$http({
			method : 'GET',
			url : url,
		}).then(function(response) {
			$scope.empresas = response.data;
			console.log(response.data);
		}, function() {

		});
	}
	
	$scope.salvarEmpresa = function(){
		$http({
			method : 'POST',
			url : url, 
			data: $scope.empresa
		}).then(function(response) {
			$scope.empresas = response.data;
			$scope.msg = 'Empresa cadastrda com sucesso';
			$scope.exibeMensagem($scope.msg);
			// retorna o estado dos campos para nunca usados
			$scope.empresaForm.$setPristine();
			//limpa o objeto
			$scope.empresa ={};
		}, function() {
			$scope.msg = 'Erro ao cadastrar';
			$scope.exibeMensagem($scope.msg);
		});
	}
	
	$scope.excluirEmpresa = function(empresa){
		$http({
			method : 'DELETE',
			url : url + empresa.id, 
			data: $scope.empresa
		}).then(function(response) {
			$scope.empresas = response.data;
			$scope.msg = 'Empresa excluida com sucesso';
			$scope.exibeMensagem($scope.msg);
			$scope.listarEmpresas();
			console.log(response.data);
		}, function() {

		});
	}
	
	$scope.buscarCnpj = function(cnpj){
		$http({
			method : 'GET',
			url : 'http://localhost:8080/cnpj/' + cnpj,
			data: $scope.empresa
		}).then(function(response) {
			$scope.empresas = response.data;
			console.log('empresa ' + response.data);
		}, function() {
			$scope.msg ="empresa não encontada"
			$scope.exibeMensagem($scope.msg);
		}); 
		
		console.log('cnpj' + cnpj);
	}
	
	$scope.buscarNome = function(nome){
		$http({
			method : 'GET',
			url : 'http://localhost:8080/nome/' + nome,
			data: $scope.empresa
		}).then(function(response) {
			$scope.empresas = response.data;
			console.log('empresa ' + response.data);
		}, function() {
			$scope.msg ="empresa não encontada"
			$scope.exibeMensagem($scope.msg);
		}); 
	}
	
	$scope.exibeMensagem = function(strmsg){
		
		$window.alert(strmsg);	
	}
	
	
	$scope.listarEmpresas();
});