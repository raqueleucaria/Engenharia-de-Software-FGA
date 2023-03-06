#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
  int dado;
  struct celula *prox;
} celula;

void mescla_listas(celula *l1, celula *l2, celula *l3)
{
  if (l2->prox == NULL && l1->prox == NULL)
  {
    return;
  }

  if (l1->prox == NULL)
  {
    l3->prox = l2->prox;
    l2->prox = l2->prox->prox;
    l3->prox->prox = NULL;
    mescla_listas(l1, l2, l3->prox);
    return;
  }

  if (l2->prox == NULL)
  {
    l3->prox = l1->prox;
    l1->prox = l1->prox->prox;
    l3->prox->prox = NULL;
    mescla_listas(l1, l2, l3->prox);
    return;
  }

  if (l1->prox->dado < l2->prox->dado)
  {
    l3->prox = l1->prox;
    l1->prox = l1->prox->prox;
    l3->prox->prox = NULL;
    mescla_listas(l1, l2, l3->prox);
  }
  else
  {
    l3->prox = l2->prox;
    l2->prox = l2->prox->prox;
    l3->prox->prox = NULL;
    mescla_listas(l1, l2, l3->prox);
  }
}