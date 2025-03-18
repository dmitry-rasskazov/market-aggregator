import React from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  useRoutes,
} from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import ProductLayout from "./pages/ProductPage/ProductLayout";
import Layout from "./pages/ResultPage/Layout";
import SearchPage from "./pages/MainPage/SearchPage";
const App = () => {
    let routes = useRoutes([
        { path: "/", element: <SearchPage /> },
        { path: "results", element: <Layout /> },
        { path: "product", element: <ProductLayout /> },
    ]);
    return routes;
};

const AppWrapper = () => {
    return (
        <Router>
            <App />
        </Router>
    );
};

export default AppWrapper;
