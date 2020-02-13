import Home from './components/Home';
import Cadastro from './components/Cadastro'
const routes = [
    { path: '/', name: 'home', component: Home, titulo: 'Home', menu: true},
    { path: '/cadastro', name: 'cadastro', component: Cadastro, titulo: 'Cadastro', menu: true},
    { path: '/cadastro/:id', name: 'altera', component: Cadastro, titulo: 'Cadastro', menu: false},
    { path: '*', name: 'default', component: Home, menu: false }
];
export default routes;