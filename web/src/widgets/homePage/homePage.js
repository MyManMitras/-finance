import React from 'react';
import LoginCard from '../loginCard/loginCard';
import AppBar from 'react-toolbox/lib/app_bar/AppBar';
import Navigation from 'react-toolbox/lib/navigation/Navigation';
import Link from 'react-toolbox/lib/link/Link';
import Footer from '../footer/footer';
import Content from '../content/content';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';
import IconMenu from 'react-toolbox/lib/menu/IconMenu';
import MenuItem from 'react-toolbox/lib/menu/MenuItem';
import MenuDivider from 'react-toolbox/lib/menu/MenuDivider';
import Button from 'react-toolbox/lib/button/Button';
import FontIcon from 'react-toolbox/lib/font_icon/FontIcon';

class HomePage extends React.Component {
  render () {
    return (
    <section>
        <AppBar title={this.props.user.firm.name} >
          <Navigation type="horizontal">
            <Button icon='person' label={this.props.user.firstName} flat style={{color: 'white'}}/>
          </Navigation>
        </AppBar>
        <Content user = {this.props.user}/>
        <Footer/>
      </section>);
  }
}

export default HomePage;