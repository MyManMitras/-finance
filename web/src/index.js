import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import ThemeProvider from 'react-toolbox/lib/ThemeProvider';
import theme from './toolbox/theme.js';
import './toolbox/theme.css';

ReactDOM.render(
  <ThemeProvider theme={theme}>
    <App />
  </ThemeProvider>,
  document.getElementById('root')
);
