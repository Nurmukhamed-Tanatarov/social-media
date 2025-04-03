import React from 'react';
import logo from './logo.svg';
import './App.css';
import {LoginPage} from "./auth/LoginPage";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <LoginPage />
      </header>
    </div>
  );
}

export default App;
