import React from 'react';
import Tab from 'react-toolbox/lib/tabs/Tab';
import Tabs from 'react-toolbox/lib/tabs/Tabs';
import Button from 'react-toolbox/lib/button/Button';
import Dashboard from '../dashboard/dashboard';
import SuperAdminDashboard from '../dashboard/superAdminDashboard';

class Content extends React.Component {
    state = {activeTabIndex: 0};

    handleTabChange = (index) => {
        this.setState({activeTabIndex: index});
    };

    welcomeBar = () => {
        return (
            <h1>
                Hello {this.props.user.firstName},
            </h1>
        );
    };

    render () {
        return (
        <section>
            <Tabs index={this.state.activeTabIndex} onChange={this.handleTabChange} inverse>
                <Tab label='Home'>
                    {this.welcomeBar()}
                    <Dashboard user={this.props.user}/>
                </Tab>
                <Tab label='Loan'>
                    <small>Loan Manager</small>
                </Tab>
                <Tab label='Deposit'>
                    <small>Deposit Manager</small>
                </Tab>
                <Tab label='Staff & Customer'>
                    <small>Person Manager</small>
                </Tab>
            </Tabs>
        </section>
        );
    };

}

export default Content;