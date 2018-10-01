appLancamentosGlobal.controller("lancamentoController",
		function($scope, $http, $window) {

			$scope.lancamentos = [];

			$scope.lancamento = {

			};

			$scope.msg = "";

			$scope.categorias = [];
			$scope.empresas = [];

			$scope.saldo = [];

			url = 'http://localhost:8080/lancamentos/';

			$scope.listarLancamentos = function() {
				$http({
					method : 'GET',
					url : url,
				}).then(function(response) {
					$scope.lancamentos = response.data;
					console.log(response.data);
				}, function() {

				});
			}

			$scope.salvarLancamento = function() {
				$http({
					method : 'POST',
					url : url,
					data : $scope.lancamento
				}).then(function(response) {
					$scope.lancamentos = response.data;
					$scope.msg = 'Lançamento cadastrado com sucesso';
					$scope.lancamento ={};
					$scope.exibeMensagem($scope.msg);
					console.log(response.data);
					$scope.mostrarSaldo();
				}, function() {
					$scope.msg = 'Erro ao cadastrar';
					$scope.exibeMensagem($scope.msg);
				});
			}

			$scope.excluirLancamento = function(lancamento) {
				$http({
					method : 'DELETE',
					url : url + lancamento.id,
					data : $scope.lancamento
				}).then(function(response) {
					$scope.lancamentos = response.data;
					$scope.exibeMensagem('Lançamento excluído com sucesso');
					$scope.listarLancamentos();
					$scope.mostrarSaldo();
				}, function() {

				});
			}

			$scope.carregarCombos = function() {
				$http({
					method : 'GET',
					url : 'http://localhost:8080/categorias/',
				}).then(function(response) {
					$scope.categorias = response.data;
					console.log(response.data);
				}, function() {

				});

				$http({
					method : 'GET',
					url : 'http://localhost:8080/empresas/',
				}).then(function(response) {
					$scope.empresas = response.data;
					console.log(response.data);
				}, function() {

				});
			}

			$scope.mostrarSaldo = function() {
				$http({
					method : 'GET',
					url : 'http://localhost:8080/mostrarsaldo/',
				}).then(function(response) {
					$scope.saldo = response.data;
					console.log(response.data);
					console.log('saldo ' + $scope.saldo);
				}, function() {
					// return $scope.saldo;
				});
			}

			$scope.exibeMensagem = function(strmsg) {

				$window.alert(strmsg);
			}

			$scope.mostrarSaldo();
			$scope.carregarCombos();
			$scope.listarLancamentos();

		});