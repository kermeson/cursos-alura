import Vue from 'vue'

Vue.directive('meu-transform', {
  bind: (el, binding, vnode) => {
    let current=0;
    el.addEventListener('dblclick', () => {      
      let incremento = 90;
      let animacao = false;
      if (binding.value) {
        incremento = binding.value.incremento
        animacao = binding.value.animacao 
      }
      if (binding.modifiers.reverse) {
        current-=incremento;
      } else {
        current+=incremento;
      }
      
      el.style.transform = `rotate(${current}deg)`;
      if (animacao) {
        el.style.transition = 'transform 0.5s';
      }
    })
  }
});