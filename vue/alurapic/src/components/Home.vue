<template>
  <div>
    <h1 class="titulo">{{ name }}</h1>

    <p v-show="mensagem" class="centralizado">{{ mensagem }}</p>

    <input type="search" placeholder="pesquise pelo título da foto" class="filtro"
    @input="filtro = $event.target.value" />

    <ul class="lista-fotos">
      <li class="lista-fotos-item" v-for="foto of fotosFiltradas" :key="foto.titulo">
        <meu-painel :titulo="foto.titulo">
         <minha-imagem :src="foto.url" :titulo="foto.titulo" v-meu-transform="{ animacao: true, incremento: 15 }"></minha-imagem>
         <router-link :to="{ name: 'altera', params: { id: foto._id }}"><meu-botao tipo="button" rotulo="alterar" /></router-link>
         <meu-botao tipo="button" rotulo="remover" @botaoAtivado="remove(foto)"
         estilo="perigo" :confirmacao="true" />
        </meu-painel>
      </li>
    </ul>
  </div>
</template>

<script>
import Painel from "./shared/Painel";
import ImagemResponsiva from "./shared/ImagemResponsiva"
import Button from "./shared/Button"
import FotoService from '../domain/foto/FotoService'

export default {
  name: "app",
  components: {
    "meu-painel": Painel,
    "minha-imagem": ImagemResponsiva,
    "meu-botao": Button
  },
  data() {
    return {
      name: "Projeto AluraPicure",
      fotos: [],
      filtro: '',
      mensagem: ''
    };
  },
  created() {
    this.fotoService = new FotoService(this.$resource);
    this.fotoService.lista().then(
        res => (this.fotos = res),
        err => this.mensagem = err.message
      );
  },
  computed: {
    fotosFiltradas() {
      if (this.filtro) {
        let exp = new RegExp(this.filtro.trim(), 'i');
        return this.fotos.filter(foto => exp.test(foto.titulo));
      } else {
        return this.fotos;
      }
    }

  },
  methods: {
    remove(foto) {
     
       this.$http
        .delete(`http://localhost:3000/v1/fotos/${foto._id}`)
        .then(() => {
            // assim que apagar, exibe a mensagem para o usuário
            this.mensagem = 'Foto removida com sucesso'

            let indice = this.fotos.indexOf(foto); // acha a posição da foto na lista
            this.fotos.splice(indice, 1); // a instrução altera o array
            
          }, 
          err => {
            this.mensagem = 'Não foi possível remover a foto';
            console.log(err);
          }
        )
     
    }
  }
};
</script>

<style>

  .titulo {
    text-align: center;
  }

  .lista-fotos {
    list-style: none;
  }

  .lista-fotos .lista-fotos-item {
    display: inline-block;
  }

  .filtro {
    width: 100%;
    height: 1.4em;
  }

</style>
