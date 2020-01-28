<template>
  <div class="corpo">
    <meu-menu :routes="routes" />
    <transition name="pagina">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
import routes from "./routes";
import Menu from "./components/shared/Menu";

export default {
  data: () => ({
    routes
  }),
  components: {
    "meu-menu": Menu
  }
};
</script>

<style>
.corpo {
  font-family: Helvetica, sans-serif;
  margin: 0 auto;
  width: 96%;
}

.pagina-enter,
.pagina-leave-active {
  opacity: 0;
}
.pagina-enter,
.pagina-leave-active {
  opacity: 0;
}

.pagina-enter-active,
.pagina-leave-active {
  transition: opacity 0.4s;
}
</style>
