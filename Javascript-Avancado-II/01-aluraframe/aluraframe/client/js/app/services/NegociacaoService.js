class NegociacaoService {

    constructor() {
        this.http = new HttpService();
    }
    obterNegociacoesDaSemana() {

        return new Promise((resolve, reject) => {

            this.http.get('negociacoes/semana')
                        .then((negociacoes) => { 
                            resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor))); 
                        })
                        .catch(erro => reject('Não foi possível obter as negociações da semana'));
        })
    }

    obterNegociacoesDaSemanaAnterior() {

        return new Promise((resolve, reject) => {

            let xhr = new XMLHttpRequest();

            xhr.open('GET', 'negociacoes/anterior');

            xhr.onreadystatechange = () => {

                if (xhr.readyState == 4) {

                    if (xhr.status == 200) {

                        resolve(JSON.parse(xhr.responseText)
                            .map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));


                    } else {

                        reject('Não foi possível obter as negociações da semana anterior.');
                    }
                }
            };

            xhr.send();
        })
    }


    obterNegociacoesDaSemanaRetrasada() {

        return new Promise((resolve, reject) => {
            let xhr = new XMLHttpRequest();

            xhr.open('GET', 'negociacoes/retrasada');

            xhr.onreadystatechange = () => {

                if (xhr.readyState == 4) {

                    if (xhr.status == 200) {

                        resolve(JSON.parse(xhr.responseText)
                            .map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));


                    } else {

                        reject('Não foi possível obter as negociações da semana retrasada.');
                    }
                }
            };

            xhr.send();
        })
    }
}
