package com.craftinginterpreters.lox;

import java.util.List;

abstract class Expr {
  // Visitor interface genérica
  interface Visitor<R> {
    R visitBinaryExpr(Binary expr);
    R visitGroupingExpr(Grouping expr);
    R visitLiteralExpr(Literal expr);
    R visitUnaryExpr(Unary expr);
  }

  // Cada Expr aceita um Visitor
  abstract <R> R accept(Visitor<R> visitor);

    // Expr.Binary
    static class Binary extends Expr {
      final Expr left;
      final Token operator;
      final Expr right;

      Binary(Expr left, Token operator, Expr right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
      }

      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitBinaryExpr(this);
      }
    }

    // Expr.Grouping
    static class Grouping extends Expr {
      final Expr expression;

      Grouping(Expr expression) {
        this.expression = expression;
      }

      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitGroupingExpr(this);
      }
    }

    // Expr.Literal
    static class Literal extends Expr {
      final Object value;

      Literal(Object value) {
        this.value = value;
      }

      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitLiteralExpr(this);
      }
    }

    // Expr.Unary
    static class Unary extends Expr {
      final Token operator;
      final Expr right;

      Unary(Token operator, Expr right) {
        this.operator = operator;
        this.right = right;
      }

      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitUnaryExpr(this);
      }
  }
}