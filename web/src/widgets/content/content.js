import React from 'react';
import Tab from 'react-toolbox/lib/tabs/Tab';
import Tabs from 'react-toolbox/lib/tabs/Tabs';
import Dashboard from '../dashboard/dashboard';
import SuperAdminDashboard from '../dashboard/superAdminDashboard';
import Loan from '../loan/loan';

class Content extends React.Component {
    state = { activeTabIndex: 0 };

    handleTabChange = (index) => {
        this.setState({ activeTabIndex: index });
    };

    welcomeBar = () => {
        return (
            <h1>
                Hello {this.props.user.firstName},
            </h1>
        );
    };

    getDashboard = () => {
        var dashboard = null;
        if (this.props.user.role === 'SuperUser') {
            dashboard = <SuperAdminDashboard user={this.props.user} />
        } else {
            dashboard = <Dashboard user={this.props.user} />;
        }
        return dashboard;
    };

    isLoanModuleDisabled = () =>{
        if(this.props.user.role === 'Manager' || this.props.user.role === 'Admin'){
            return false;
        }
        return true;
    };

    render() {
        return (
            <section>
                <Tabs index={this.state.activeTabIndex} onChange={this.handleTabChange} inverse>
                    <Tab label='Home'>
                        {this.welcomeBar()}
                        {this.getDashboard()}
                    </Tab>
                    <Tab label='Loan' disabled={this.isLoanModuleDisabled()}>
                        <Loan/>
                    </Tab>
                    <Tab label='Deposit' disabled>
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