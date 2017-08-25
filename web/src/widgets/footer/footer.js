import React from 'react';

const footerStyle = {
    width: '100%',
    borderTop: '2px solid',
    color: 'white',
    background: 'rgb(63, 81, 181)',
    padding: '1em',
    position: 'relative',
    right: '0',
    bottom: '0',
    left: '0'
};

class Footer extends React.Component {
    render() {
        return (
            <footer style={footerStyle}>
                <span>
                    <p style={{ margin: '0' }}>
                        For questions/queries/assitance/support get in touch with us. We are happy to help...<br />
                        Email: MyManMitras@gmail.com | Phone: NNNNNNNNNN | Address: ............
                    </p>
                </span>
            </footer>
        );
    };

}

export default Footer;