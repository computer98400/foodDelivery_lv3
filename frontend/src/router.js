
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderTableManager from "./components/listers/OrderTableCards"
import OrderTableDetail from "./components/listers/OrderTableDetail"

import StoreTableManager from "./components/listers/StoreTableCards"
import StoreTableDetail from "./components/listers/StoreTableDetail"

import RiderTableManager from "./components/listers/RiderTableCards"
import RiderTableDetail from "./components/listers/RiderTableDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderTables',
                name: 'OrderTableManager',
                component: OrderTableManager
            },
            {
                path: '/orderTables/:id',
                name: 'OrderTableDetail',
                component: OrderTableDetail
            },

            {
                path: '/storeTables',
                name: 'StoreTableManager',
                component: StoreTableManager
            },
            {
                path: '/storeTables/:id',
                name: 'StoreTableDetail',
                component: StoreTableDetail
            },

            {
                path: '/riderTables',
                name: 'RiderTableManager',
                component: RiderTableManager
            },
            {
                path: '/riderTables/:id',
                name: 'RiderTableDetail',
                component: RiderTableDetail
            },




    ]
})
