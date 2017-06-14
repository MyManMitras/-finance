const path = require('path');
const webpack = require('webpack');

const settings = {
  entry: {
    bundle: [
      "./web/scripts/index.js"
    ]
  },
  output: {
    filename: "pack.js",
    publicPath: "/",
    path: path.resolve("web/dist")
  },
  resolve: {
    extensions: [".js", ".json", ".css"]
  },
  devtool: "eval-source-map",
  module: {
    rules: [
      {
        test: /\.js?$/,
        loader: 'babel-loader',
        options: {
          presets: [
            ["es2015", { modules: false }],
            "stage-2",
            "react"
          ],
          plugins: [
            "transform-node-env-inline", "react-hot-loader/babel"
          ],
          env: {
            development: {
              plugins: ["react-hot-loader/babel"],
              presets: [
                ["es2015", { modules: false }],
                "stage-2",
                "react"
                ]
            }
          }
        }
      },
      {
        test: /\.scss$/, loaders: [ 'style-loader', 'css-loader', 'sass-loader','font-loader' ]
      },
      {
        test: /\.jpe?g$|\.gif$|\.png$|\.svg$|\.woff$|\.ttf$|\.wav$|\.mp3$/, loader: "file-loader"
      },
      {
        test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000'
      },  
      {
        test: /\.css$/,
        use: [
          "style-loader",
          {
            loader: "css-loader",
            options: {
              modules: true,
              sourceMap: true,
              importLoaders: 1,
              localIdentName: "[name]--[local]--[hash:base64:8]"
            }
          },
          "postcss-loader" // has separate config, see postcss.config.js nearby
        ]
      },
    ]
  },
  devServer: {
    contentBase: path.resolve("web"),
    publicPath: "http://localhost:8181/", // full URL is necessary for Hot Module Replacement if additional path will be added.
    quiet: false,
    hot: true,
    historyApiFallback: true,
    inline: true
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NamedModulesPlugin(),
    new webpack.LoaderOptionsPlugin({
      debug: true
    }),
  ],
};

module.exports = settings;